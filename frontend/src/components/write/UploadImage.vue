<template>
  <div class="image">
    <div class="empty-box">
      <img
        v-if="origin"
        :src="imagePath"
        alt="" />
      <label for="input-file">
        <i
          v-if="!origin"
          class="fa-solid fa-plus add-icon"></i>
      </label>
    </div>
    <input
      id="input-file"
      ref="image"
      type="file"
      accept="image/*"
      @change="getImage" />
  </div>
</template>

<script>
import { mapState } from 'vuex'
import AWS from 'aws-sdk'

export default {
  name: 'UploadImage',
  props: {
    origin: String,
  },
  data () {
    return {
      file: '',
      fileName: '',
    }
  },
  computed: {
    ...mapState('user', ['username']),
    imagePath() {
      return process.env.S3_SERVER_URL + this.origin
    },
    photoKey() {
      return this.username + Date.now() + '.jpg'
    }
  },
  watch: {
    location() {
      
    }
  },
  methods: {
    getImage() {
      this.file = this.$refs.image.files[0]
      this.fileName = this.file.name

      this.submitProfilePhoto()
    },
    async submitProfilePhoto() {
      const albumBucketName = process.env.S3_BUCKET
      const region = 'ap-northeast-2'
      const accessKeyId = process.env.S3_ACCESS_KEY_ID
      const secretAccessKey = process.env.S3_SECRET_ACCESS_KEY
      
      AWS.config.update({
        region,
        accessKeyId,
        secretAccessKey
      })

      const s3 = new AWS.S3({
        apiVersion:'2012-10-17',
        params: {
          Bucket: albumBucketName,
        }
      })

      const file = this.file
      const fileName = this.photoKey
      const albumPhotosKey = encodeURIComponent('images') + '/'
      const photoKey = albumPhotosKey + fileName
      
      s3.upload({
        Key: photoKey,
        Body: file,
        ACL: 'public-read'
      }).promise()
        .then((res) => {
          this.$emit('upload', res.Key)
        })
    }
  }
}
</script>

<style lang="scss" scoped>
  .image {
    margin: 20px 0;
    .empty-box {
      position: relative;
      width: 160px;
      height: 90px;
      background-color: $color-light;
      border-radius: 10px;
      overflow: hidden;

      img {
        width: 100%;
        height: auto;
        object-fit: cover;
      }

      i {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        
        font-size: 24px;
        color: $color-grey;
        cursor: pointer;
      }

      
    }
    input[type="file"]{
      display: none;
    }
  }
</style>

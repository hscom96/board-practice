<template>
  <div class="image">
    <div class="empty-box">
      <label for="input-file">
        <i class="fa-solid fa-plus add-icon"></i>
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
import AWS from 'aws-sdk'

export default {
  name: 'UploadImage',
  data () {
    return {
      image: '',
      fileName: '',
      location: ''
    }
  },
    methods: {
    getImage() {
      this.image = this.$refs.image.files[0]
      this.fileName = this.image.name

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

      const file = this.image
      const fileName = this.fileName
      const albumPhotosKey = encodeURIComponent('images') + '/'
      const photoKey = albumPhotosKey + fileName
      
      s3.upload({
        Key: photoKey,
        Body: file,
        ACL: 'public-read'
      }).promise()
        .then((res) => {
          this.location = res.Location
        })
    }
  }
}
</script>

<style lang="scss" scoped>
  .image {
    margin-top: 10px;
    .empty-box {
      width: 160px;
      height: 90px;
      background-color: $color-light;
      border-radius: 10px;
      display: flex;
      align-items: center;
      justify-content: center;

      .add-icon {
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

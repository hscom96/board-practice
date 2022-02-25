import router from '~/routes'
import userApi from '~/utils/api/user.js'

const state = {
  userId: null,
  username: '',
  nickname: ''
}

const actions = {
  async onLogin({ commit }, userData) {
    try {
      const { data } = await userApi.login(userData)
      if (data.code === 200) {
        commit('SET_USER_ID', data.data.user_id)
        commit('SET_USERNAME', data.data.user_name)
        commit('SET_NICKNAME', data.data.name)
        router.push({ name: 'ArticleList' })
      } else {
        alert(data.message)
      }
    } catch (err) {
      console.log(err.response)
    }
  },
  async onSignup({ commit }, userData) {
    try {
      const { data } = await userApi.signup(userData)
      if (data.code === 200) {
        router.push({ name: 'Login' })
      } else {
        alert(data.message)
      }
      commit()
    } catch (err) {
      console.log(err.response)
    }
  },
}

const mutations = {
  SET_USER_ID(state, payload) {
    state.userId = payload
  },
  SET_USERNAME(state, payload) {
    state.username = payload
  },
  SET_NICKNAME(state, payload) {
    state.nickname = payload
  },
}

const getters = {

}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
  getters
}

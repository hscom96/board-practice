import userApi from '~/utils/api/user.js'

const state = {
  userId: null,
  username: ''
}

const actions = {
  async onLogin({ commit }, userData) {
    try {
      const { data } = await userApi.login(userData)
      console.log(data)
      commit()
    } catch (err) {
      console.log(err.response)
    }
  }
}

const mutations = {
  SET_USER_ID(state, payload) {
    state.userId = payload
  },
  SET_USERNAME(state, payload) {
    state.username = payload
  }
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

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);


export default new Vuex.Store({
    state: {
        visible: false
    },
    getters: {},
    mutations: {},
    actions: {
        menuVisible(state, visible) {
            console.log("menuVisible : ", visible);
            state.visible = visible;
            console.log(state.visible);
        }
    }
})

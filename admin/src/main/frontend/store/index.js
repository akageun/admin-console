import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);


export default new Vuex.Store({
    state: {
        visible: false
    },
    getters: {
        getVisible(state) {
            return state.visible;
        }
    },
    mutations: {},
    actions: {
        menuVisible(state, visible) {
            state.visible = visible;
            console.log("stste ", state.visible);
        }
    }
})

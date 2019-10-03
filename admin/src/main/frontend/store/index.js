import Vue from 'vue';
import Vuex from 'vuex';

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
    mutations: {
        menuVisible(state, visible) {
            state.visible = visible;
            console.log("stste ", state.visible);
        }
    },
    actions: {
        // API's can be called here and then accordingly can be passed for mutation

    }
});

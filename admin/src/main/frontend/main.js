// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import axios from 'axios';

import SuiVue from 'semantic-ui-vue';
import 'semantic-ui-css/semantic.min.css';

import commonSidebar from "@/components/layout/common-sidebar";
import commonFooter from "@/components/layout/common-footer";
import commonHeader from "@/components/layout/common-header";


Vue.component(commonSidebar.name, commonSidebar);
Vue.component(commonFooter.name, commonFooter);
Vue.component(commonHeader.name, commonHeader);

Vue.use(SuiVue);

Vue.config.productionTip = false;
Vue.prototype.$http = axios; //모든페이지에서 axios를 편하게 사용하기 위함.

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    components: {App},
    template: '<App/>',
})

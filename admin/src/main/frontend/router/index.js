import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/home'
import loginForm from '@/views/user/login-form'
import manageNoticeBbs from '@/views/manage/manage-notice-bbs'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/login',
            name: 'login',
            component: loginForm
        },
        {
            path: "/manage/notice/list",
            name: "manageNoticeBbs",
            component: manageNoticeBbs
        },
    ]
})

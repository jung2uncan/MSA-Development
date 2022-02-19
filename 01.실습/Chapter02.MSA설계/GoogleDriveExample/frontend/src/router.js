
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import Dashboard from "./components/Dashboard"
import FileManager from "./components/FileManager"

import IndexManager from "./components/IndexManager"

import VideoManager from "./components/VideoManager"

import NotificationManager from "./components/NotificationManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/dashboards',
                name: 'Dashboard',
                component: Dashboard
            },
            {
                path: '/files',
                name: 'FileManager',
                component: FileManager
            },

            {
                path: '/indices',
                name: 'IndexManager',
                component: IndexManager
            },

            {
                path: '/videos',
                name: 'VideoManager',
                component: VideoManager
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },



    ]
})

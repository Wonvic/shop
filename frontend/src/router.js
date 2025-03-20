
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CoreOrderOrderManager from "./components/listers/CoreOrderOrderCards"
import CoreOrderOrderDetail from "./components/listers/CoreOrderOrderDetail"

import SuppotingDeliveryDeliveryManager from "./components/listers/SuppotingDeliveryDeliveryCards"
import SuppotingDeliveryDeliveryDetail from "./components/listers/SuppotingDeliveryDeliveryDetail"
import SuppotingDeliveryInventoryManager from "./components/listers/SuppotingDeliveryInventoryCards"
import SuppotingDeliveryInventoryDetail from "./components/listers/SuppotingDeliveryInventoryDetail"


import MyViewView from "./components/MyViewView"
import MyViewViewDetail from "./components/MyViewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/coreOrders/orders',
                name: 'CoreOrderOrderManager',
                component: CoreOrderOrderManager
            },
            {
                path: '/coreOrders/orders/:id',
                name: 'CoreOrderOrderDetail',
                component: CoreOrderOrderDetail
            },

            {
                path: '/suppotingDeliveries/deliveries',
                name: 'SuppotingDeliveryDeliveryManager',
                component: SuppotingDeliveryDeliveryManager
            },
            {
                path: '/suppotingDeliveries/deliveries/:id',
                name: 'SuppotingDeliveryDeliveryDetail',
                component: SuppotingDeliveryDeliveryDetail
            },
            {
                path: '/suppotingDeliveries/inventories',
                name: 'SuppotingDeliveryInventoryManager',
                component: SuppotingDeliveryInventoryManager
            },
            {
                path: '/suppotingDeliveries/inventories/:id',
                name: 'SuppotingDeliveryInventoryDetail',
                component: SuppotingDeliveryInventoryDetail
            },


            {
                path: '/dashboardServices/myViews',
                name: 'MyViewView',
                component: MyViewView
            },
            {
                path: '/dashboardServices/myViews/:id',
                name: 'MyViewViewDetail',
                component: MyViewViewDetail
            },


    ]
})

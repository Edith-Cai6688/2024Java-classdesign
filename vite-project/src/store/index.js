import Vue from 'vue'
import Vuex from 'vuex'

import { getItem,setItem } from '../api/storage'
import { Loading } from 'element-plus/es/components/loading/src/service.mjs';

Vue.use(Vuex);
const TOKEN_KEY='X_Token';

export default new Vuex.Store({
    state:{
        user:getItem(TOKEN_KEY),
        Loading:false
    },
    mutation:{
        setUser(state,data){
            state.user=data;
            setItem(TOKEN_KEY,state.user);
        },
        showloading(state){
            state.Loading=true;
        },
        hideloading(state){
            state.Loading=false;
        }
    },
    actions:{

    },
    modules:{
        
    }
}

)
import { createApp } from 'vue'
import router from '@/router/index.js'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import "@/assets/global.css"
import axios from 'axios'



// import "@/assets/less/index.less";



axios.interceptors.request.use(config=>{
  config.headers.Authorization=window.localStorage.getItem("token");
  console.log(config);
  return config;
})
const app=createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

app.use(router);
app.use(ElementPlus);
app.mount('#app')

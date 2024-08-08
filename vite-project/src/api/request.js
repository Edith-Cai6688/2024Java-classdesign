import axios from 'axios';
import store from '@/store/index.js'
const requests=axios.create(
    {
        baseURL:'/api',
        timeout:50000,
    }
);

requests.interceptors.request.use(
    function(config){
        store.commit("showLoading");
        return config;
    },
    function(error){
        store.commit("hideLoading");
        return Promise.reject(error);
    }
);

requests.interceptors.response.use(
    function(response){
        return response;
    },
    function(error){
        return Promise.reject(error);
    }   
);

request.interceptors.response.use(
    function (response) {
      store.commit("hideLoading");
      return response;
    },
    async function (error) {
      store.commit("hideLoading");
      // console.dir(error);
      if (error.response && error.response.status === 400) {
        // 校验是否有token，没有的话请求失败，提示重新登陆
        const user = store.state.user;
        if (!user || !user.refresh_token) {
          router.push("/selectchongzhi");
          return;
        }
        // 如果有refresh_token，则请求获取新的 token
        try {
          const res = await axios({
            method: "PUT", // 对数据进行全部更新
            url: "/admin/waterMeter/login",
            headers: { "X-Token": localStorage.getItem("X-Token") },
          });
   
          // 如果获取成功，则把新的 token 更新到容器中
          console.log("刷新 token 成功", res);
          store.commit("setUser", {
            token: res.data.data.token, // 最新获取的可用 token
            refresh_token: user.refresh_token, // 还是原来的 refresh_token
          });
          return request(error.config);
        } catch (err) {
          // 如果获取失败跳转首页
          console.log("请求刷线 token 失败", err);
          router.push("/selectchongzhi");
        }
      }
      return Promise.reject(error);
    }
  );
  

export default requests;
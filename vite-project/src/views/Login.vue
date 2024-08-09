<template>
    <div class="login_container">
        <div class="login_box">
            <div class="avatar_box">
                <img src="@/assets/images/ironman.png" alt="">
            </div>
            <el-form ref="formRef" :model="loginform" :rules="rules" class="login_form">
                <el-form-item prop="username" >
                <el-input v-model="loginform.account" >
                    <template #prefix>
                        <el-icon><el-icon><el-icon><User /></el-icon></el-icon></el-icon>
                    </template>
                </el-input>
                </el-form-item>
                <el-form-item prop="password">
                <el-input v-model="loginform.password" type="password">
                    <template #prefix>
                        <el-icon><el-icon><Lock /></el-icon></el-icon>
                    </template>
                </el-input>
                </el-form-item>
                <el-form-item class="btns">
                    <div><el-button  type="primary" @click="submit">登录</el-button></div>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script setup>
    import{reactive,ref}from "vue"
    import { ElMessage } from 'element-plus';
    import axios from "axios";
    import router from "@/router/index.js"
    const formRef=ref(null);
    const loginform=reactive({
        account:"",
        password:""
    })


    const rules={
        account:[{required:true,message:"请输入用户名",trigger:'blur'}],
        password:[{required:true,message:"请输入密码",trigger:'blur'}]
    }
    

    const submit=()=>{
        formRef.value.validate((valid)=>{
            if(valid){
                    const res=axios.post('/api/login',
                        {
                            account:loginform.account,
                            password:loginform.password
                        },
                        {
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        }
                    )
                    .then(function(res){                
                        console.log(res);
                        if(res.data.code===1){
                            ElMessage({
                            message:"登陆成功",
                            type:'success'                   
                            });
                            router.push('/home');
                        }else{
                            ElMessage.error('账号密码错误')
                        }
                    }
                    )
                    .catch(function(error){
                        console.log(error);
                    });
                    console.log(res);
    
                
            }
        }

        )
    }
        
    
</script>

<style lang="less" scoped>
    .login_container{
 //       background-color:lightsteelblue;
        background-image: url("src/assets/images/ironman_back.png");
        width: 100%;
        height: 100%;
    }
    .login_box{
        width:450px;
        height:300px;
        background-color: aliceblue;
        border-radius: 3px;
        position: absolute;
        top:50%;
        left:50%;
        transform: translate(-50%,-50%);
        .avatar_box{
        height: 130px;
        width: 130px;
        border:1px solid #fff;
        border-radius: 50%;
        padding:10px;
        box-shadow: 0 0 10px #ddd;
        position:absolute;
        left:50%;
        transform: translate(-50%,-50%);
        background-color: aliceblue;
        img{
            height: 100%;
            width: 100%;
            border-radius: 50%;
        }}
    }
    .login_form{
        position:absolute;
        bottom:0;
        width:100%;
        padding: 0 20px;
        box-sizing: border-box;
        
    }
    .btns{
        display: grid;
        justify-content:center;
    }
    
</style>
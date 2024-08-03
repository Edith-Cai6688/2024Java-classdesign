<template>
    <div class="login_container">
        <div class="login_box">
            <div class="avatar_box">
                <img src="@/assets/images/ironman.png" alt="">
            </div>
            <el-form  :model="loginform" class="login_form">
                <el-form-item >
                <el-input v-model="loginform.username">
                    <template #prefix>
                        <el-icon><el-icon><el-icon><User /></el-icon></el-icon></el-icon>
                    </template>
                </el-input>
                </el-form-item>
                <el-form-item >
                <el-input v-model="loginform.password" type="password">
                    <template #prefix>
                        <el-icon><el-icon><Lock /></el-icon></el-icon>
                    </template>
                </el-input>
                </el-form-item>
                <el-form-item>
                    <el-select
                    v-model="options.value"
                    placeholder="Select"
                    style="width: 100%"
                    >
                    <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    />
                    </el-select>
                </el-form-item>
                <el-form-item class="btns">
                    <div><el-button  type="primary" @click="login()">登录</el-button></div>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import { ElMessage } from 'element-plus'; 
    export default{
        data(){
            return{
                loginform:{
                    username:"",
                    password:""
                },
                options:[
                    {
                        value:'1',
                        label:'管理员'
                    },
                    {
                        value:'2',
                        label:'教师'
                    },
                    {
                        value:'3',
                        label:'学生'
                    }
                ]
            }
        },
        methods:{
            login(){
                console.log(this);
                if(this.loginform.username==="cyt" && this.loginform.password==="123456" && this.options.value==='3'){
                    this.$router.push("/home")
                    ElMessage({
                        message: 'Congrats, 密码正确！',
                        type: 'success',
                    })
                }else{
                        ElMessage.error('Oops,密码错误!')
                    }
            }
        }
    };
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
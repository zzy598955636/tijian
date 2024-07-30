<script setup lang="ts">
import router from '../../router/index';
import { reactive, ref, getCurrentInstance, onMounted } from 'vue';
const { proxy } = getCurrentInstance();
const header = reactive({
    keyword: '',
    tags: [
        {
            label: '入职体检',
            type: 'info'
        },
        {
            label: '父母体检',
            type: 'info'
        },
        {
            label: '女士体检',
            type: 'info'
        }
    ]
});

</script>

<template>
<div class="container">
    <header>
        <div class="logo-container">
            <img src="../../assets/front/index/logo.png" class="logo" />
            <div>
                <h3>神州大健康</h3>
                <p>www.chinahealty.com</p>
            </div>
        </div>
        <!-- 这里是新添加的内容 -->
        <div class="search-container">
            <div>
                <el-input v-model="header.keyword" placeholder="请输入套餐名或者编号"
                    size="large" maxlength="50" class="keyword-input"
                    clearable>
                    <template #append>
                        <el-button>搜索</el-button>
                    </template>
                </el-input>
            </div>
            <div>
                <el-tag v-for="item in header.tags" :key="item.label"
                    :type="item.type" class="tag" effect="light" round>
                    {{ item.label }}
                </el-tag>
            </div>
        </div>
    </header>
    <!-- 避免路由引用页面的时候浏览器不刷新内容，所以给URL添加随机数参数 -->
    <router-view :key="router.currentRoute.value.query.random" />
</div>


</template>

<style lang="less" scoped>  
    @import url('main.less');
</style>
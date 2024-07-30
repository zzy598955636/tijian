<template>
    <!-- 避免路由引用页面的时候浏览器不刷新内容，所以给URL添加随机数参数 -->
    <router-view :key="router.currentRoute.value.query.random" />
</template>

<script lang="ts" setup>
import router from '../../router/index';
</script>

<style lang="less" scoped>
    @import url('main.less');
</style>

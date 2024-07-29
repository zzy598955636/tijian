<template>
	<div>
		index
		<h3>{{msg}}</h3>
		<p>
			<el-button type="primary" @click="changeMsg">Primary</el-button>
		</p>
		<p><SvgIcon name="assurance_fill" class="icon-svg" /></p>
	</div>
</template>

<script lang="ts" setup>
	import { ref, Ref } from 'vue';
	import SvgIcon from '../../components/SvgIcon.vue';
	let msg:Ref<string>=ref("HelloWorld")
	function changeMsg(){
		msg.value="你好世界"
	}
</script>

<style>
</style>
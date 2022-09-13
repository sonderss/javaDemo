<template>
  <div>
    <div> {{ msg }}</div>
    <button @click="toDetail">跳转</button>
  </div>
</template>

<script setup>
import {ref } from "vue"
const msg = ref(1231323132)

const toDetail = function () {
  return  // router.push('/detail')
}
</script>

<template>
  <div>
    <div>{{ msg }}</div>
    <button @click="toIndex">跳转</button>
  </div>
</template>

<script setup>
import {ref} from "vue"
const msg = ref('detail')
const toIndex = () => {
  // router.push('/')
}
</script>

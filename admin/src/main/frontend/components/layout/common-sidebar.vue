<template>
    <sui-sidebar animation="overlay" class="inverted" :visible="this.$store.state.visible">
        <!-- links -->
        <a class="item">
            <i class="sticky note icon"></i>
            Bulletin
        </a>
        <a class="item">
            <i class="newspaper icon"></i>
            News
        </a>
        <a class="item">
            <i class="mail icon"></i>
            Contact us
        </a>
    </sui-sidebar>
</template>

<script>
    export default {
        name: "common-sidebar",
        data: () => ({}),
    }
</script>

<style scoped>

</style>

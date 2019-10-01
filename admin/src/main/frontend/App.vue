<template>
    <div>
        <!-- Sidebar -->
        <div class="ui right demo vertical sidebar labeled icon menu" id="mobile-sidebar">
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
        </div>

        <div class="ui fixed inverted main menu mobile-menu">
            <div class="ui container">
                <div class="item">
                    Menu
                </div>
                <div class="right menu">

                    <a class="launch icon item" id="mobile-menu-trigger" v-on:click="toggle">
                        <i class="content icon"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="pusher">
            <h1>
                Hello Vue
            </h1>
        </div>

    </div>
</template>

<script>
    export default {
        name: 'App',
        data: function () {
            return {
                isToggled: false,
                sideBar: null
            }
        },
        methods: {
            toggle: function () {
                if (this.isToggled) {
                    this.sideBar.sidebar('hide')
                } else {
                    this.sideBar.sidebar('show')
                }
            }
        },
        mounted: function () {
            this.sideBar = document.getElementById('mobile-sidebar');
            let self = this
            this.sideBar.sidebar({
                transition: 'push',
                onHidden: function () {
                    self.isToggled = false
                },
                onShow: function () {
                    self.isToggled = true
                }
            })
        }

    }
</script>

<style>
</style>

<template>
    <div class="background">
        <sui-grid centered vertical-align="middle">
            <sui-grid-column>

                <h2 is="sui-header" color="teal" image>
                    <sui-header-content>회원가입</sui-header-content>
                </h2>

                <sui-form onsubmit="return false;">
                    <sui-segment stacked aligned="left">
                        <sui-form-field>
                            <label>Email</label>
                            <input placeholder="First Name">
                        </sui-form-field>
                        <sui-form-field>
                            <label>Password</label>
                            <input placeholder="Last Name">
                        </sui-form-field>
                        <sui-form-field>
                            <label>Password Confirm</label>
                            <input placeholder="Last Name">
                        </sui-form-field>
                        <sui-form-field>
                            <sui-checkbox label="I agree to the Terms and Conditions"/>
                        </sui-form-field>
                        <sui-button size="large" color="teal" fluid @click="signup">Sign Up</sui-button>
                    </sui-segment>
                </sui-form>
            </sui-grid-column>
        </sui-grid>
    </div>
</template>

<script>
    export default {
        name: "sign-up-form",
        data: () => ({

        }),
        methods: {
            signup() {
                console.log("test");
            }
        }
    }
</script>

<style scoped>
    .background {
        background-color: #DADADA !important;
        height: 100vh;
        margin: 1em 0;
    }

    .grid {
        height: 100%;
    }

    .column {
        max-width: 450px;
        text-align: center !important;
    }
</style>

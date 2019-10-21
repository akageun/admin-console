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
                            <label>user Id</label>
                            <input type="text" placeholder="User Id" v-model="userId">
                        </sui-form-field>
                        <sui-form-field>
                            <label>Password</label>
                            <input type="password" placeholder="Password" v-model="passWd">
                        </sui-form-field>
                        <sui-form-field>
                            <label>Password Confirm</label>
                            <input type="password" placeholder="Confirm Password" v-model="confirmPassWd">
                        </sui-form-field>
                        <sui-form-field>
                            <label>Email</label>
                            <input type="email" placeholder="Email" v-model="email">
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
            userId: '',
            passWd: '',
            confirmPassWd: '',
            email: ''
        }),
        methods: {
            signup() {
                console.log(this.userId, this.passWd, this.confirmPassWd, this.email);
                if (!this.valid()) {
                    return;
                }

                this.$http.post(`/api/signup/v1/form`, {
                    userId: this.userId,
                    passWd: this.passWd,
                    confirmPassWd: this.confirmPassWd,
                    email: this.email
                })
                    .then((data) => {
                        console.log("data ", data)

                    })
                    .catch((error) => {
                        console.log("에러 ", error);
                    });

            },
            valid() {
                if (!this.userId) {
                    alert("아이디를 입력해주세요.");
                    return false;
                }

                if (!this.passWd) {
                    alert("비밀번호를 입력해주세요.")
                    return false;
                }

                if (!this.confirmPassWd) {
                    alert("비밀번호를 다시한번 입력해주세요.")
                    return false;
                }

                if (this.passWd !== this.confirmPassWd) {
                    alert("비밀번호가 일치하지 않습니다.");
                    return false;
                }

                if (!this.email) {
                    alert("이메일을 입력해주세요.");
                    return false;
                }

                return true;
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

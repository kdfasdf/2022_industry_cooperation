<template>
  <div class="join-comp">
    <h3 align="center">기업 회원가입</h3>
    <b-form @submit="joinCompUser">
      <!-- 기업 이름 -->
      <b-form-group label="Name" label-for="input-name">
        <b-form-input
          id="input-name"
          type="text"
          v-model="form.name"
          placeholder="Enter Company Name"
          required
        ></b-form-input>
      </b-form-group>

      <!-- id / pw -->
      <b-form-group label="ID" label-for="input-ID">
        <b-form-input
          id="input-ID"
          type="text"
          v-model="form.id"
          placeholder="Enter ID"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group label="PW" label-for="input-PW">
        <b-form-input
          id="input-PW"
          type="password"
          v-model="form.pw"
          placeholder="Enter Password"
          required
        ></b-form-input>
      </b-form-group>

      <!-- HR 담당자 이름 -->
      <b-form-group label="HR" label-for="input-hr">
        <b-form-input
          id="input-hr"
          type="text"
          v-model="form.hr"
          placeholder="Enter HR Name"
          required
        ></b-form-input>
      </b-form-group>

      <!-- email -->
      <b-form-group label="E-mail" label-for="input-email">
        <b-form-input
          id="input-email"
          type="email"
          v-model="form.email"
          placeholder="Enter E-mail"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 연락처 -->
      <b-form-group label="Contact" label-for="input-contact">
        <b-form-input
          id="input-contact"
          type="text"
          v-model="form.contact"
          placeholder="Enter Contact Information"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 기업 분야 -->
      <b-form-group label="Category" label-for="input-category">
        <b-form-select
          id="input-category"
          v-model="form.category"
          :options="categoryOptions"
        ></b-form-select>
      </b-form-group>

      <!-- 기업 규모 -->
      <b-form-group label="Company Size" label-for="input-size">
        <b-form-select
          id="input-size"
          v-model="form.size"
          :options="sizeOptions"
        ></b-form-select>
      </b-form-group>

      <b-button type="submit" variant="primary">완료</b-button>
    </b-form>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "JoinComp",
  data() {
    return {
      form: {
        name: "",
        id: "",
        pw: "",
        hr: "",
        email: "",
        contact: "",
        category: "",
        size: "",
      },
      categoryOptions: [
        { text: "반도체", value: "c1" },
        { text: "자동차", value: "c2" },
        { text: "SNS/포털", value: "c3" },
      ],
      sizeOptions: [
        { text: "대기업", value: "s1" },
        { text: "중기업", value: "s2" },
        { text: "소기업", value: "s3" },
      ],
    };
  },
  methods: {
    joinCompUser() {
      http
        .post("/success-join-comp", {
          co_ID: this.form.id,
          co_PW: this.form.pw,
          company: this.form.name,
          hr: this.form.hr,
          co_EMAIL: this.form.email,
          co_NUMBER: this.form.contact,
          category_ID: this.form.category,
          size_ID: this.form.size
        })
        .then((response) => {
          console.log(response.data);
          alert("회원가입 완료!");
          this.$router.push({ name: "Login" });
        })
        .catch((e) => {
          console.log(e);
          alert("회원가입 실패..");
          this.$router.go(0);
        });
    },
  },
};
</script>

<style scoped>
.join-comp {
  padding: 30px;
  margin: 0 auto;
  width: 300px;
}
</style>

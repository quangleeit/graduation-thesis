package com.quangleeit.itsecuritylearning;

import android.os.AsyncTask;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegisterActivity extends AppCompatActivity {


    EditText edtUsername, edtPassword, edtXNPassword;
    Button btnRegiser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       /* edtUsername = (EditText) findViewById(R.id.editTenDn);
        edtPassword = (EditText) findViewById(R.id.editMK);
        edtXNPassword = (EditText) findViewById(R.id.editNhplaiMK);

        btnRegiser = (Button) findViewById(R.id.buttonRegister);
        btnRegiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtUsername.getText().toString();
                String matkhau = edtPassword.getText().toString();
                String nhaplaimatkhau = edtXNPassword.getText().toString();

                if(nhaplaimatkhau.equals(matkhau)){
                    ItemUser user = new ItemUser();
                    user.setTentk(taikhoan);
                    user.setMatkhau(matkhau);

                    AsynDangKy asyDK = new AsynDangKy();
                    asyDK.execute(user);

                }else {
                    Toast.makeText(RegisterActivity.this, "Nhập lại mật khẩu không đúng...!", Toast.LENGTH_SHORT).show();
                }
            }
        }); */

    }
/*
    public class AsynDangKy extends AsyncTask<ItemUser, Void, Integer>{

        @Override
        protected Integer doInBackground(ItemUser... itemUsers) {
            WebService sv = new WebService();
            int kiemtra = 0;
          //  kiemtra = sv.ThemTaiKhoan(itemUsers[0]);
            return kiemtra;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            if(result > 0){
                Toast.makeText(RegisterActivity.this, "Thêm thành công tài khoản!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(RegisterActivity.this, "Thất bại!", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

}

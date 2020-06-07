package kr.tjoeun.library_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvent()
        setValues()
    }

    override fun setupEvent() {

        profileImg.setOnClickListener{
            Log.d("메인화면" , "이미지 뷰 클릭")
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)
        }



    }

    override fun setValues() {
        Glide.with(mContext).load("https://www.mimint.co.kr/article/thumbnail.asp?thumb=http%3A%2F%2Fimg%2Eezmember%2Eco%2Ekr%2Fcache%2Fboard%2F2017%2F11%2F29%2Fca8f6c5404fc8dd7c53e18fa29f00898%2Ejpg").into(profileImg)
    }


}

package kr.tjoeun.library_20200607

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

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

        callBtn.setOnClickListener {

//                전화를 걸기 전에 CALL 권한을 얻었는지 체크.
//                권한을 허가 받은 경우에만 => 실제로 전화

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                        허가가 난 경우
                    //               실제 전화를 거는 코드
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext , "권한이 거부되어 통화를 할 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("거절되면 통화할 수 없으니 [설정]에서 권한을 허가해주세요.")
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()
        }

    }

    override fun setValues() {
        Glide.with(mContext).load("https://www.mimint.co.kr/article/thumbnail.asp?thumb=http%3A%2F%2Fimg%2Eezmember%2Eco%2Ekr%2Fcache%2Fboard%2F2017%2F11%2F29%2Fca8f6c5404fc8dd7c53e18fa29f00898%2Ejpg").into(profileImg)
    }


}

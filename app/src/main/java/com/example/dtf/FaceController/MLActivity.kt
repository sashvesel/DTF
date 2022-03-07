package com.example.dtf.FaceController

import android.content.pm.PackageManager
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageCapture
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.dtf.FaceDetection.CameraManager
import com.example.dtf.FaceDetection.FaceContourDetectionProcessor
import com.example.dtf.FaceDetection.FaceContourGraphic
import com.example.dtf.GraphicOverlay
import com.example.dtf.R
import com.example.dtf.databinding.ActivityMlactivityBinding
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceContour
import kotlinx.android.synthetic.main.activity_mlactivity.*


class MLActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMlactivityBinding
    private lateinit var cameraManager: CameraManager
    private lateinit var faceContourGraphic: FaceContourGraphic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_mlactivity)

        createCameraManager()
        checkForPermission()

    }


    private fun checkForPermission() {
        if (allPermissionsGranted()) {
            cameraManager.startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                cameraManager.startCamera()
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }
    }

    private fun createCameraManager() {
        cameraManager = CameraManager(
            this,
            binding.preview,
            this,
            graphicOverlay_finder
        )
    }


    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }


    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
    }

}


package com.example.dtf.FaceDetection


import android.graphics.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import androidx.camera.core.CameraX.getContext
import com.example.dtf.GraphicOverlay
import com.google.mlkit.vision.common.PointF3D
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceContour

class FaceContourGraphic(
    overlay: GraphicOverlay,
    private val face: Face,
    private val imageRect: Rect
) : GraphicOverlay.Graphic(overlay) {

    private val idPaint: Paint
    private val boxPaint: Paint
    private val pointPaint: Paint

    init {

        val selectedColor = Color.RED

        idPaint = Paint()
        idPaint.color = selectedColor
        idPaint.textSize = 40.0f

        boxPaint = Paint()
        boxPaint.color = selectedColor
        boxPaint.style = Paint.Style.STROKE
        boxPaint.strokeWidth = BOX_STROKE_WIDTH

        pointPaint = Paint()
        pointPaint.color = selectedColor
        pointPaint.strokeWidth = BOX_STROKE_WIDTH

    }

    override fun draw(canvas: Canvas?) {

        val mPoints18 = face.getContour(1).points.get(18)
        val point0 = canvas?.drawPoint(mPoints18.x,mPoints18.y,pointPaint)
        val txt18 = canvas?.drawText("point 18", mPoints18.x + 20.0F, mPoints18.y, idPaint)

        

    }


    companion object {
        private const val BOX_STROKE_WIDTH = 10.0f
    }

}





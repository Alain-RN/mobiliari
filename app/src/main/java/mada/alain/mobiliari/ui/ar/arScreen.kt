package mada.alain.mobiliari.ui.ar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ar.core.Config
import com.google.ar.core.Frame
import com.google.ar.core.Plane
import com.google.ar.core.TrackingFailureReason
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.arcore.createAnchorOrNull
import io.github.sceneview.ar.arcore.getUpdatedPlanes
import io.github.sceneview.ar.arcore.isValid
import io.github.sceneview.ar.getDescription
import io.github.sceneview.ar.rememberARCameraNode
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.rememberCollisionSystem
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberMaterialLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes
import io.github.sceneview.rememberOnGestureListener
import io.github.sceneview.rememberView
import mada.alain.mobiliari.R
import mada.alain.mobiliari.createAnchorNode

//  navController.popBackStack() retour
//
//@Composable
//fun ArScreen(
////    navController: NavController
//) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//
//        val kModelFile = "models/damaged_helmet.glb"
//        val kMaxModelInstances = 10
//
//        val engine = rememberEngine()
//        val modelLoader = rememberModelLoader(engine)
//        val materialLoader = rememberMaterialLoader(engine)
//        val cameraNode = rememberARCameraNode(engine)
//        val childNodes = rememberNodes()
//        val view = rememberView(engine)
//        val collisionSystem = rememberCollisionSystem(view)
//
//        var planeRenderer by remember { mutableStateOf(true) }
//
//        val modelInstances = remember { mutableListOf<ModelInstance>() }
//        var trackingFailureReason by remember {
//            mutableStateOf<TrackingFailureReason?>(null)
//        }
//        var frame by remember { mutableStateOf<Frame?>(null) }
//        ARScene(
//            modifier = Modifier.fillMaxSize(),
//            childNodes = childNodes,
//            engine = engine,
//            view = view,
//            modelLoader = modelLoader,
//            collisionSystem = collisionSystem,
//            sessionConfiguration = { session, config ->
//                config.depthMode =
//                    when (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
//                        true -> Config.DepthMode.AUTOMATIC
//                        else -> Config.DepthMode.DISABLED
//                    }
//                config.instantPlacementMode = Config.InstantPlacementMode.LOCAL_Y_UP
//                config.lightEstimationMode =
//                    Config.LightEstimationMode.ENVIRONMENTAL_HDR
//            },
//            cameraNode = cameraNode,
//            planeRenderer = planeRenderer,
//            onTrackingFailureChanged = {
//                trackingFailureReason = it
//            },
//            onSessionUpdated = { session, updatedFrame ->
//                frame = updatedFrame
//
//                if (childNodes.isEmpty()) {
//                    updatedFrame.getUpdatedPlanes()
//                        .firstOrNull { it.type == Plane.Type.HORIZONTAL_UPWARD_FACING }
//                        ?.let { it.createAnchorOrNull(it.centerPose) }?.let { anchor ->
//                            childNodes += createAnchorNode(
//                                kModelFile = kModelFile,
//                                kMaxModelInstances = kMaxModelInstances,
//                                engine = engine,
//                                modelLoader = modelLoader,
//                                materialLoader = materialLoader,
//                                modelInstances = modelInstances,
//                                anchor = anchor
//                            )
//                        }
//                }
//            },
//            onGestureListener = rememberOnGestureListener(
//                onSingleTapConfirmed = { motionEvent, node ->
//                    if (node == null) {
//                        val hitResults = frame?.hitTest(motionEvent.x, motionEvent.y)
//                        hitResults?.firstOrNull {
//                            it.isValid(
//                                depthPoint = false,
//                                point = false
//                            )
//                        }?.createAnchorOrNull()
//                            ?.let { anchor ->
//                                planeRenderer = false
//                                childNodes += createAnchorNode(
//                                    kModelFile = kModelFile,
//                                    kMaxModelInstances = kMaxModelInstances,
//                                    engine = engine,
//                                    modelLoader = modelLoader,
//                                    materialLoader = materialLoader,
//                                    modelInstances = modelInstances,
//                                    anchor = anchor
//                                )
//                            }
//                    }
//                })
//        )
//        Text(
//            modifier = Modifier
//                .systemBarsPadding()
//                .fillMaxWidth()
//                .align(Alignment.TopCenter)
//                .padding(top = 16.dp, start = 32.dp, end = 32.dp),
//            textAlign = TextAlign.Center,
//            fontSize = 28.sp,
//            color = Color.White,
//            text = trackingFailureReason?.getDescription(LocalContext.current) ?: if (childNodes.isEmpty()) {
//                stringResource(R.string.point_your_phone_down)
//            } else {
//                stringResource(R.string.tap_anywhere_to_add_model)
//            }
//        )
//    }
//}



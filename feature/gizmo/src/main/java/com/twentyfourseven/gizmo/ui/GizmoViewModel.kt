package com.twentyfourseven.gizmo.ui

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.lifecycle.ViewModel
import com.twentyfourseven.gizmo.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GizmoViewModel @Inject constructor() : ViewModel() {
    private val attributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_ASSISTANCE_ACCESSIBILITY)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()

    private var _soundPool: SoundPool? = SoundPool.Builder()
        .setMaxStreams(26)
        .setAudioAttributes(attributes)
        .build()

    private val soundPool = _soundPool

    private val _notesList: MutableList<Int?> = mutableListOf()
    val notesList: List<Int?> = _notesList

    suspend fun loadSoundPool(context: Context) {
        withContext(Dispatchers.IO) {
            val typedArray = context.resources.obtainTypedArray(R.array.notes_list)
            for (i in 0 until typedArray.length()) {
                val note = typedArray.getResourceId(i, 0)
                val noteId = soundPool?.load(context, note, 1)
                _notesList.add(noteId)
            }
            typedArray.recycle()
        }
    }

    fun playSound(index: Int) {
        val actualIndex = index.mod(notesList.size)
        notesList[actualIndex]?.let { noteId ->
            soundPool?.play(noteId, 1f, 1f, 0, 0, 1f)
        }
    }

    override fun onCleared() {
        _soundPool?.release()
        _soundPool = null
        super.onCleared()
    }
}
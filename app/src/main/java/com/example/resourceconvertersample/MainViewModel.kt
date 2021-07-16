package com.example.resourceconvertersample

import androidx.databinding.InverseMethod
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val testText = MediatorLiveData<String>().also { observer ->
        observer.addSource(testType) { type ->
            observer.value = type?.let { it ->
                when (it) {
                    TestType.TEST_1 -> "test1"
                    TestType.TEST_2 -> "test2"
                    TestType.TEST_3 -> "test3"
                }
            } ?: ""
        }
    }

    val testType = MutableLiveData<TestType?>()
}

enum class TestType {
    TEST_1, TEST_2, TEST_3;
}

object TestTypeConverter {
    @InverseMethod("toType")
    @JvmStatic
    fun toInt(testType: TestType): Int {
        return when (testType) {
            TestType.TEST_1 -> R.id.test1
            TestType.TEST_2 -> R.id.test2
            TestType.TEST_3 -> R.id.test3
        }
    }

    @JvmStatic
    fun toType(selectedId: Int): TestType? {
        return when (selectedId) {
            R.id.test1 -> TestType.TEST_1
            R.id.test2 -> TestType.TEST_2
            R.id.test3 -> TestType.TEST_3
            else -> null
        }
    }
}
package com.example.flagquiz

import android.graphics.Color
import android.graphics.Path.Direction
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.flagquiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentQuizBinding
    lateinit var mQuestionList: ArrayList<Question>
    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer : Int = 0
    var mCurrentPosition: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        mQuestionList = Constants.getQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setQuestion()

        return binding.root
    }

    private fun setQuestion() {
        var question: Question = mQuestionList[mCurrentPosition - 1]

        binding.tvQuestion.text = question.question
        binding.imageView.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        binding.pb.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.pb.max

        defaultAppearance()

        if (mCurrentPosition == mQuestionList.size){
            binding.btnSubmit.text = "Quiz Finished"
        } else {
            binding.btnSubmit.text = "Submit"
        }
    }

    private fun defaultAppearance() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = context?.let { ContextCompat.getDrawable(it, R.drawable.default_option_border_bg) }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_optionOne-> {
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tv_optionTwo-> {
                selectedOptionView(binding.tvOptionTwo, 2)
            }
            R.id.tv_optionThree-> {
                selectedOptionView(binding.tvOptionThree, 3)
            }
            R.id.tv_optionFour-> {
                selectedOptionView(binding.tvOptionFour, 4)
            }
            R.id.btnSubmit-> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList.size -> {
                            setQuestion()
                        } else -> {
                            val nameOfPlayer by navArgs<QuizFragmentArgs>()
                            val action = QuizFragmentDirections.actionQuizFragmentToScoreFragment(
                                score = mCorrectAnswer,
                                name = nameOfPlayer.name)
                            findNavController().navigate(action)

                            Toast.makeText(context, "QUIZ SELESAI", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionList[mCurrentPosition - 1]

                    if (question!!.correctAnswer != mSelectedPosition) {
                        answerView(mSelectedPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswer++
                    }

                    if (mCurrentPosition == mQuestionList.size){
                        binding.btnSubmit.text = "Selesai"
                    } else {
                        binding.btnSubmit.text = "Soal Selanjutnya"
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    mSelectedPosition = 0

                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedPosition: Int) {
        defaultAppearance()

        mSelectedPosition = selectedPosition

        tv.setTextColor(Color.parseColor("#363A43"))

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = context?.let { ContextCompat.getDrawable(it, R.drawable.selected_option_border_bg) }
    }

    private fun answerView(mSelectedPosition: Int, drawableView: Int) {
        when (mSelectedPosition) {
            1 -> {
                binding.tvOptionOne.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }
            2 -> {
                binding.tvOptionTwo.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }
            3 -> {
                binding.tvOptionThree.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }
            4 -> {
                binding.tvOptionFour.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }
        }
    }
}
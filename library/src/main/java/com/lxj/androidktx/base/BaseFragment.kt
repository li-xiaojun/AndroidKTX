package com.lxj.androidktx.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.FragmentUtils

/**
 * Description: 外部容器要使用ViewPager2，自带懒加载效果
 * Create by dance, at 2019/5/16
 */
abstract class BaseFragment: Fragment(), FragmentUtils.OnBackClickListener{

    private var hasInitData = false
    private var hasInitView = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!hasInitView){
            hasInitView = true
            initView()
        }
    }

    override fun onResume() {
        super.onResume()
        if(!hasInitData){
            hasInitData = true
            initData()
        }
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()

    override fun onBackClick() = false
}
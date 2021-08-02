package com.example.common.base.recyclerView.viewHolder

import android.graphics.drawable.AnimationDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import com.example.common.databinding.ViewNetworkStateBinding
import com.example.common.util.ext.visible
import com.example.common.R
import com.example.common.util.ext.click
import com.example.common.util.ext.gone

class NetworkStateViewHolder(
    binding: ViewNetworkStateBinding,
    private val retryCallback: () -> Unit
) : BaseViewHolder<LoadState, ViewNetworkStateBinding>(binding) {

    companion object {
        fun create(
            parent: ViewGroup,
            retryCallback: () -> Unit
        ): NetworkStateViewHolder {
            return NetworkStateViewHolder(
                ViewNetworkStateBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                retryCallback
            )
        }
    }

    override fun extraBinding(item: LoadState) {
        when (item) {
            is LoadState.Loading -> {
                binding.imageViewLoading.apply {
                    this.visible()
                    (this.drawable as? AnimationDrawable)?.start()
                }
                binding.textViewMessage.apply {
                    this.visible()
                    this.setText(R.string.loading)
                }
                binding.buttonRetry.gone()
            }

            is LoadState.Error -> {
                binding.imageViewLoading.apply {
                    this.gone()
                    (this.drawable as? AnimationDrawable)?.stop()
                }
                binding.textViewMessage.apply {
                    this.visible()
                    this.setText(R.string.action_retry)
                }
                binding.buttonRetry.visible()
            }

            else -> {
                binding.imageViewLoading.apply {
                    this.gone()
                    (this.drawable as? AnimationDrawable)?.stop()
                }
                binding.textViewMessage.gone()
                binding.buttonRetry.gone()
            }
        }

        binding.buttonRetry.click {
            retryCallback.invoke()
        }
    }

    override fun onClick(view: View, item: LoadState) = Unit
}

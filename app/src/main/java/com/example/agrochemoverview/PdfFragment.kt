package com.example.agrochemoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.android.synthetic.main.fragment_pdf.*

class PdfFragment:Fragment() {

    val args : PdfFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pdf,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val assetName = args.assetName
        val mPDFView: PDFView = pdfView
        mPDFView.fromAsset(assetName).load()

    }

}
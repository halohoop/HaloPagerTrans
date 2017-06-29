# HaloPagerTrans

## 效果

![demo0](demo0.gif)

## HOW TO USE

### Set Animation for every single view

* By calling View.setTag() to set params of the animations


        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            View imageView3 = view.findViewById(R.id.imageView3);
            imageView3.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
            imageView3.setTag(ChildsTranslateTransformer.KEY_IS_REVERSE, true);
            imageView3.setTag(ChildsTranslateTransformer.KEY_MARGIN_WHEN_REVERSE, -30f);
    
            View line = view.findViewById(R.id.line);
            line.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
            line.setTag(ChildsTranslateTransformer.KEY_IS_REVERSE, true);
            line.setTag(ChildsTranslateTransformer.KEY_MARGIN_WHEN_REVERSE, -70f);
    
            View ll_top = view.findViewById(R.id.ll_top);
            ll_top.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
            ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE, -90f);
            ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1f);
            ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 0.5f);
    
            View textView1 = view.findViewById(R.id.textView1);
            textView1.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 3f);
    
            View imageView1 = view.findViewById(R.id.imageView1);
            imageView1.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
            imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE, 90f);
            imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1f);
            imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 0.5f);
        }

### Set Animation for the page view(ViewGroup)

* The same, by calling View.setTag() to set params of the animations

### Set Complex Animation for the page view(ViewGroup)

* choose one or more Transformers to add into the complex one
 



            ComplexChildsTransformer complexChildsTransformer = new ComplexChildsTransformer();
            complexChildsTransformer.addTransformer(new ChildsTranslateTransformer());
            complexChildsTransformer.addTransformer(new ChildsRotateTransformer());
            complexChildsTransformer.addTransformer(new ChildsAlphaTransformer());
            complexChildsTransformer.addTransformer(new ChildsScaleTransformer());
            //choose one or more Transformers to add into the complex one
            //complexChildsTransformer.addTransformer(new PageDefaultTransformer());//普通vp滑动
            //complexChildsTransformer.addTransformer(new PageAlphaTransFormer(false/*可修改*/, true/*可修改*/));//透明度
            //complexChildsTransformer.addTransformer(new PageCubeInnerTransformer(/*可传参数*/));//立方体内部
            //complexChildsTransformer.addTransformer(new PageCubeOuterTransformer());//立方体外部
            //complexChildsTransformer.addTransformer(new PageDepthTransformer(/*可传参数*/));//深度变化
            //complexChildsTransformer.addTransformer(new PageExtrudingTransformer());//挤压
            complexChildsTransformer.addTransformer(new PageFlipTransformer(/*可传参数*/));//flip
            //complexChildsTransformer.addTransformer(new PageInRightUpTransformer());//右上到左下
            //complexChildsTransformer.addTransformer(new PageInRightDownTransformer());//右下到左上
            //complexChildsTransformer.addTransformer(new PageRotateTransformer(/*可传参数*/));//旋转
            //complexChildsTransformer.addTransformer(new PageZoomOutTransformer(/*可传参数*/));//Zoom out
            vp.setPageTransformer(true, complexChildsTransformer);

## More Detail

* See [http://halohoop.com](http://halohoop.com)

## License

    Copyright 2017, Halohoop

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
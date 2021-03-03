package com.convict;

import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * @author: Convict.Yellow
 * @date: 2021/3/3 10:08
 * @description: BrowserController
 */
public class Controller {
    public TextField urlTextField;
    public WebView webView;

    public void back() {
        if (webView.getEngine().getHistory().getCurrentIndex() > 0) {
            webView.getEngine().getHistory().go(-1);
        }
    }

    public void next() {
        if (webView.getEngine().getHistory().currentIndexProperty().getValue() < webView.getEngine().getHistory().getEntries().size() - 1) {
            webView.getEngine().getHistory().go(1);
        }
    }

    public void refresh() {
        webView.getEngine().reload();
    }

    public void home() {
        go("https://www.baidu.com");
    }

    public void go() {
        go(urlTextField.getText());
    }

    public void go(String urlString) {
        webView.getEngine().load(urlString);
    }

}

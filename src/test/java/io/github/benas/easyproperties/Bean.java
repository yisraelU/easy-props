/*
 *   The MIT License
 *
 *    Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *    Permission is hereby granted, free of charge, to any person obtaining a copy
 *    of this software and associated documentation files (the "Software"), to deal
 *    in the Software without restriction, including without limitation the rights
 *    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *    copies of the Software, and to permit persons to whom the Software is
 *    furnished to do so, subject to the following conditions:
 *
 *    The above copyright notice and this permission notice shall be included in
 *    all copies or substantial portions of the Software.
 *
 *    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *    THE SOFTWARE.
 */

package io.github.benas.easyproperties;

import io.github.benas.easyproperties.annotations.*;

public class Bean {

    @SystemProperty("user.home")
    private String userHome;

    @SystemProperty(value = "blah", defaultValue = "default")
    private String value;

    @SystemProperty("threshold")
    private int threshold;

    @Property(source = "myProperties.properties", key = "bean.name")
    private String beanName;

    @Property(source = "myProperties.properties", key = "empty.key")
    private String emptyField;

    @I18NProperty(bundle = "i18n/messages", key = "my.message")
    private String message;

    @Properties("myProperties.properties")
    private java.util.Properties myProperties;

    @JNDIProperty("foo.property")
    private String jndiProperty;

    @MavenProperty(key = "version", groupId = "commons-beanutils", artifactId = "commons-beanutils")
    private String pomVersion;

    @ManifestProperty(jar = "junit-4.12.jar", header = "Created-By")
    private String createdBy;

    @MyCustomAnnotation(value = "foo")
    private String custom;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public java.util.Properties getMyProperties() {
        return myProperties;
    }

    public void setMyProperties(java.util.Properties myProperties) {
        this.myProperties = myProperties;
    }

    public String getJndiProperty() {
        return jndiProperty;
    }

    public void setJndiProperty(String jndiProperty) {
        this.jndiProperty = jndiProperty;
    }

    public String getPomVersion() {
        return pomVersion;
    }

    public void setPomVersion(String pomVersion) {
        this.pomVersion = pomVersion;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEmptyField() {
        return emptyField;
    }

    public void setEmptyField(String emptyField) {
        this.emptyField = emptyField;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}

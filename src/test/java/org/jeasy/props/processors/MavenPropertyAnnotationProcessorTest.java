/**
 * The MIT License
 *
 *   Copyright (c) 2017, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.jeasy.props.processors;

import org.jeasy.props.annotations.MavenProperty;
import org.jeasy.props.api.PropertyInjectionException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MavenPropertyAnnotationProcessorTest extends AbstractAnnotationProcessorTest {

    @Test
    public void testMavenPropertyInjection() {
        //given
        Bean bean = new Bean();

        //when
        propertiesInjector.injectProperties(bean);

        //then
        assertThat(bean.getPomVersion()).isEqualTo("1.9.2");
    }

    @Test(expected = PropertyInjectionException.class)
    public void whenSourceIsInvalid_thenShouldThrowAnException() throws Exception {
        //given
        BeanWithInvalidSource bean = new BeanWithInvalidSource();

        //when
        propertiesInjector.injectProperties(bean);

        //then should throw an exception
    }

    @Test
    public void whenKeyIsMissing_thenShouldSilentlyIgnoreTheField() {
        //given
        BeanWithInvalidKey bean = new BeanWithInvalidKey();

        //when
        propertiesInjector.injectProperties(bean);

        //then
        assertThat(bean.getPomVersion()).isNull();
    }

    @Test(expected = PropertyInjectionException.class)
    public void whenGroupIdIsMissing_thenShouldThrowAnException() throws Exception {
        //given
        BeanWithInvalidGroupId bean = new BeanWithInvalidGroupId();

        //when
        propertiesInjector.injectProperties(bean);

        //then
        assertThat(bean.getPomVersion()).isNull();
    }

    @Test(expected = PropertyInjectionException.class)
    public void whenArtifactIdIsMissing_thenShouldThrowAnException() throws Exception {
        //given
        BeanWithInvalidArtifactId bean = new BeanWithInvalidArtifactId();

        //when
        propertiesInjector.injectProperties(bean);

        //then
        assertThat(bean.getPomVersion()).isNull();
    }

    public class Bean {

        @MavenProperty(key = "version", groupId = "commons-beanutils", artifactId = "commons-beanutils")
        private String pomVersion;

        public String getPomVersion() { return pomVersion; }
        public void setPomVersion(String pomVersion) { this.pomVersion = pomVersion; }
    }

    public class BeanWithInvalidSource {

        @MavenProperty(source = "blah.properties", key = "version", groupId = "commons-beanutils", artifactId = "commons-beanutils")
        private String pomVersion;

        public String getPomVersion() { return pomVersion; }
        public void setPomVersion(String pomVersion) { this.pomVersion = pomVersion; }
    }

    public class BeanWithInvalidKey {

        @MavenProperty(key = "blah", groupId = "commons-beanutils", artifactId = "commons-beanutils")
        private String pomVersion;

        public String getPomVersion() { return pomVersion; }
        public void setPomVersion(String pomVersion) { this.pomVersion = pomVersion; }
    }

    public class BeanWithInvalidGroupId {

        @MavenProperty(key = "version", groupId = "blah", artifactId = "commons-beanutils")
        private String pomVersion;

        public String getPomVersion() { return pomVersion; }
        public void setPomVersion(String pomVersion) { this.pomVersion = pomVersion; }
    }

    public class BeanWithInvalidArtifactId {

        @MavenProperty(key = "version", groupId = "commons-beanutils", artifactId = "blah")
        private String pomVersion;

        public String getPomVersion() { return pomVersion; }
        public void setPomVersion(String pomVersion) { this.pomVersion = pomVersion; }
    }
}

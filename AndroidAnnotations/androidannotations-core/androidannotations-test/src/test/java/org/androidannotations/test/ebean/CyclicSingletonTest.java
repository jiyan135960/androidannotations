/**
 * Copyright (C) 2010-2016 eBusiness Information, Excilys Group
 * Copyright (C) 2016-2017 the AndroidAnnotations project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.test.ebean;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.setupActivity;

import org.androidannotations.test.EmptyActivityWithoutLayout_;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class CyclicSingletonTest {

	@Test
	public void cyclicSingleton() {
		EmptyActivityWithoutLayout_ context = setupActivity(EmptyActivityWithoutLayout_.class);
		SomeCyclicSingletonA_ singletonA = SomeCyclicSingletonA_.getInstance_(context);
		SomeCyclicSingletonB_ singletonB = SomeCyclicSingletonB_.getInstance_(context);
		assertThat(singletonA.singletonB).isSameAs(singletonB);
		assertThat(singletonB.singletonA).isSameAs(singletonA);
	}

}

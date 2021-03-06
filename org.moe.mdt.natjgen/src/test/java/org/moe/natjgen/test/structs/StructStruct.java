/*
Copyright 2014-2016 Intel Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.moe.natjgen.test.structs;

import org.moe.natjgen.Constants;
import org.moe.natjgen.test.AbstractNatJGenTest;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

public class StructStruct extends AbstractStructTest {

	public void test_getter_f1() {
		MethodDeclaration method = getMethod("f1");
		AbstractNatJGenTest.assertExistsAndGenerated(method);

		AbstractNatJGenTest.assertSimpleType(method.getReturnType2(), "CallbackStruct");

		AbstractNatJGenTest.assertNumberOfArguments(method, 0);

		NormalAnnotation sfa = AbstractNatJGenTest.assertHasNormalAnnotation(method, Constants.StructureFieldAnnotationFQ);
		AbstractNatJGenTest.assertNormalAnnotationHasValue(sfa, "isGetter", true);
	}

	public void test_setter_f1() {
		MethodDeclaration method = getMethod("setF1");
		AbstractNatJGenTest.assertExistsAndGenerated(method);

		AbstractNatJGenTest.assertPrimitiveType(method.getReturnType2(), "void");

		AbstractNatJGenTest.assertNumberOfArguments(method, 1);
		AbstractNatJGenTest.assertSimpleType(((SingleVariableDeclaration)method.parameters().get(0)).getType(), "CallbackStruct");

		NormalAnnotation sfa = AbstractNatJGenTest.assertHasNormalAnnotation(method, Constants.StructureFieldAnnotationFQ);
		AbstractNatJGenTest.assertNormalAnnotationHasValue(sfa, "isGetter", false);
	}

}

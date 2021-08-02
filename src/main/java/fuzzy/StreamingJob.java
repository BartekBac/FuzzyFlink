/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fuzzy;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.*;
import fuzzy.operators.interfaces.*;
import fuzzy.operators.joinDefinitions.WalkingPersonJoinDefinition;
import fuzzy.operators.projections.PersonProjection;
import fuzzy.operators.projections.WalkingPersonProjection;
import fuzzy.variables.AlphabeticCharacter;
import fuzzy.variables.LinguisticAge;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;
import java.util.List;


/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class StreamingJob {

	public static void main(String[] args) throws Exception {
		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		List<Person> input = Arrays.asList(
				new Person(0, "arek", 14),
				new Person(1, "marek", 26),
				new Person(2, "darek", 50)
		);
		DataStream<Person> inputDataStream = env.fromCollection(input);

		List<WalkVelocity> inputWalkVelocity = Arrays.asList(
				new WalkVelocity(0, "fast", 14),
				new WalkVelocity(1, "slow", 50)
		);
		DataStream<WalkVelocity> inputWalkVelocityDataStream = env.fromCollection(inputWalkVelocity);


		//WHERE
		/*IFuzzyFilter<Person> youngPeopleFilter = new YoungPeopleFilter();
		youngPeopleFilter.setLowerBound(13);
		youngPeopleFilter.setUpperBound(20);
		youngPeopleFilter.setMembershipCoefficient(0.5);
		IFuzzyWhere<Person> fuzzyWhere = new FuzzyWhere();

		DataStream<Person> outDataStream = fuzzyWhere.transform(inputDataStream, youngPeopleFilter);*/


		//SELECT
		/*IFuzzySelect<PersonProjection, Person> fuzzySelect = new FuzzySelect();
		DataStream<PersonProjection> outDataStream = fuzzySelect.transform(inputDataStream, new PersonProjection());*/


		//JOIN
		/*JoinFunction<Person, WalkVelocity, WalkingPersonProjection> joinFunction = new JoinFunction<Person, WalkVelocity, WalkingPersonProjection>(){
			@Override
			public WalkingPersonProjection join(Person object, WalkVelocity joined) {
				return new WalkingPersonProjection(object,  joined);
			}
		};*/
		IFuzzyJoinDefinition<WalkingPersonProjection, Person, WalkVelocity> joinDefinition = new WalkingPersonJoinDefinition();

		//WalkingPersonJoinDefinition joinDefinition = new WalkingPersonJoinDefinition();

		IFuzzyJoin<Person, WalkVelocity> fuzzyJoin = new FuzzyJoin();

		DataStream<WalkingPersonProjection> outDataStream = fuzzyJoin.transform(inputDataStream, inputWalkVelocityDataStream, person -> new LinguisticAge(person.age).returnStringValue(), walkVelocity -> new LinguisticAge(walkVelocity.age).returnStringValue(), joinDefinition.getFunction());

		/*
		Nie działa z powodów opisanych w FuzzyNumericJoin
		FuzzyNumericJoin<WalkingPersonProjection> fuzzyNumericJoin = new FuzzyNumericJoin<WalkingPersonProjection>();
		DataStream<WalkingPersonProjection> outDataStream = fuzzyNumericJoin.transform(inputDataStream, inputWalkVelocityDataStream, new WalkingPersonProjection());*/

		/*
		// GROUP BY
		FuzzyGroupBy<Person, String> fuzzyGroupBy = new FuzzyGroupBy();
		DataStream<Person> outDataStream = fuzzyGroupBy.transform(inputDataStream, person -> new LinguisticAge(person.age).returnStringValue());*/
		//inputDataStream.print();
		outDataStream.print();

		env.execute("Window WordCount");
	}
}

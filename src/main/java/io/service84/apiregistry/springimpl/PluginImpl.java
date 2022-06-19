/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.service84.apiregistry.springimpl;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.tasks.TaskContainer;

public class PluginImpl implements Plugin<Project> {
  public static final String SpringImpl = "springImpl";
  public static final String ProcessServiceDefinitionsTask = "processServiceDefinitions";

  @Override
  public void apply(Project project) {
    TaskContainer tasks = project.getTasks();
    ConfigurationContainer configurations = project.getConfigurations();

    configurations.create(SpringImpl);

    Task processServiceDefinitionsTask = tasks.findByName(ProcessServiceDefinitionsTask);

    if (processServiceDefinitionsTask == null) {
      processServiceDefinitionsTask = tasks.create(ProcessServiceDefinitionsTask);
    }

    processServiceDefinitionsTask.doLast(new ProcessServiceDefinitionsAction(project));
  }
}

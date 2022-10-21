package org.vlang.project

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.util.io.exists
import org.vlang.configurations.VlangProjectSettingsState.Companion.projectSettings
import org.vlang.utils.isNotVlangFile
import org.vlang.utils.toPath

class MissingToolchainNotificationProvider(project: Project) : VlangEditorNotificationProvider(project) {
    override fun createNotificationPanel(file: VirtualFile, editor: FileEditor, project: Project): EditorNotificationPanel? {
        if (file.isNotVlangFile || isNotificationDisabled(file)) {
            return null
        }

        val toolchainLocation = project.projectSettings.toolchainLocation
        if (toolchainLocation.isEmpty()) {
            return createNotification("V toolchain is not defined", project, file)
        }

        if (!toolchainLocation.toPath().exists()) {
            return createNotification("V toolchain folder $toolchainLocation is not exist", project, file)
        }

        val stdlibLocation = project.projectSettings.stdlibLocation
        if (stdlibLocation.isEmpty()) {
            return createNotification("V standard library is not defined", project, file)
        }

        if (!stdlibLocation.toPath().exists()) {
            return createNotification("V standard library folder $stdlibLocation is not exist", project, file)
        }

        val modulesLocation = project.projectSettings.modulesLocation
        if (!modulesLocation.toPath().exists()) {
            return createNotification("V modules folder $modulesLocation is not exist", project, file)
        }

        return null
    }
}
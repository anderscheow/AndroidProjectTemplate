import groovy.util.XmlParser
import groovy.xml.XmlUtil

rootProject.name = "Template-Android"

includeBuild("module-config-plugin")

include(
    ":app",
    ":main",
    ":common",
    ":feature_one",
    "libs:lib_base_source",
    "libs:lib_data_source"
)

includeWithApi(
    ":main",
    ":feature_one"
)

fun includeWithApi(vararg pluginPaths: String) {
    pluginPaths.forEach {
        generateApiModule(it)
    }
}

fun generateApiModule(pluginPath: String) {
    // load plugin module
    include(pluginPath)

    val pluginDir = project(pluginPath).projectDir.path
    val apiDir = "${pluginDir}_api"

    // copy apiManifest.xml from common module to api module
    val commonDir = project(":common").projectDir.path

    copy {
        from("${commonDir}/apiManifest.xml")
        into("${apiDir}/src/main/")
    }

    File("${apiDir}/src/main/apiManifest.xml").renameTo(File("${apiDir}/src/main/AndroidManifest.xml"))

    fixManifestAndGeneratePackage(
        File("${pluginDir}/src/main/AndroidManifest.xml"),
        File("${apiDir}/src/main/AndroidManifest.xml"),
        apiDir
    )

    // load api module
    include("${pluginPath}_api")
}

fun fixManifestAndGeneratePackage(pluginManifest: File, apiManifest: File, apiDir: String) {
    val apiPackageName = "${XmlParser().parse(pluginManifest).get("@package")}.api"
    val xml = XmlParser().parse(apiManifest)
    xml.attributes()["package"] = apiPackageName
    XmlUtil.serialize(xml, apiManifest.writer(Charsets.UTF_8))
    File("${apiDir}/src/main/java/${apiPackageName}").mkdir()
}
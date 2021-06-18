package ito.akira.hexagonal.api;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@AnalyzeClasses(packages = "ito.akira.hexagonal.api", importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class})
public class ArchitectureTests {

    @ArchTest
    static ArchRule no_generic_exceptions = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchTest
    static ArchRule do_not_use_jodatime = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

    @ArchTest
    static ArchRule do_not_use_field_injection = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    static ArchRule layeredArchitecture =
            layeredArchitecture()
                    .layer("Application").definedBy("..application..")
//                    .layer("ApplicationOther").definedBy("..springframework..", "..swagger..", "java..")
                    .layer("Configuration").definedBy("..configuration..")
                    .layer("Core").definedBy("..core..")
                    .layer("Infraestructure").definedBy("..infraestructure..")

                    .whereLayer("Configuration").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Application").mayOnlyBeAccessedByLayers("Configuration")
//                    .whereLayer("Application").mayOnlyAccessLayers("Core", "Application", "Configuration", "ApplicationOther")
//                    .whereLayer("Core").mayOnlyAccessLayers("Core")
//                    .whereLayer("Core").mayOnlyBeAccessedByLayers("Application", "Infraestructure", "Configuration")
//                    .whereLayer("Core").mayOnlyAccessLayers("Infraestructure")
                    .whereLayer("Infraestructure").mayOnlyBeAccessedByLayers("Core", "Configuration", "Infraestructure", "Application");

    //    @Test
    void contextLoads() {
        JavaClasses importedClass = new ClassFileImporter().importPackages("ito.akira.hexagonal.api");

//        ClassesShouldConjunction rule = classes().that().resideInAPackage("controller")
//                .should().onlyBeAccessed().byAnyPackage("..service..");

        Architectures.OnionArchitecture onionArchitecture = Architectures.onionArchitecture()
                .domainModels("com.myapp.domain.model..")
                .domainServices("com.myapp.domain.service..")
                .applicationServices("com.myapp.application..")
                .adapter("cli", "com.myapp.adapter.cli..")
                .adapter("persistence", "com.myapp.adapter.persistence..")
                .adapter("rest", "com.myapp.adapter.rest..");

        onionArchitecture.check(importedClass);


    }


}

/**
 * 
 */
/**
 * 
 */
module customCompiler {
	requires antlr;
	requires java.xml;

}

/*
 ANTLR (Another Tool for Language Recognition) is a powerful parser generator used to read, process, and translate structured text or programming languages. 
 It takes a grammar file (with .g4 extension) as input and generates lexer and parser classes in Java, which can then be used to build compilers, interpreters, 
 or any program that needs to understand a structured input. These generated classes depend on the ANTLR runtime library, which is provided as a JAR (Java ARchive) 
 file — a packaged collection of Java classes and metadata. Yes, ANTLR itself is distributed as a JAR file (antlr-4.x-complete.jar), and it acts as a dependency 
 in the project, meaning it must be available in the build path for the generated lexer/parser to function correctly. In modern Java projects, especially those
  using the module system (module-info.java), such dependencies are not automatically linked; we have to manually add them to the module path and explicitly declare
   them using requires antlr.runtime;. This manual declaration is necessary because most third-party libraries, including ANTLR, are not modular by default and do not
    include their own module descriptors, requiring the developer to define the dependency relationship within their own module. ANTLR is widely used in building
     compilers, interpreters, DSLs (domain-specific languages), and tools that require syntactic analysis.
 */

/*
 The Java Module System (introduced in Java 9) is a way to organize and manage large Java applications by grouping related packages into modules. A module is a higher-level 
 structure than a package — it explicitly declares what packages it exports (makes visible to other modules) and what other modules it requires (depends on).

Each module has a special file named module-info.java which:

Defines the module’s name

Lists its dependencies (requires)

Lists what it makes accessible to other modules (exports)

Better encapsulation: You can hide internal implementation details and expose only what's necessary.

Dependency control: You avoid "classpath hell" — accidental conflicts between libraries.

Improved startup and performance: JVM can load only the required parts.

Security: Restricts what’s accessible from outside a module.
 */

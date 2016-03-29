# makefile for DS2_Prac1

BINDIR = bin
JAVAC = javac
COMPILER = java
SRCDIR = dictionary
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)

.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<
	
all: Harness.class AbstracHashTable.class \

run: all
	$(COMPILER) -cp $(BINDIR) BSTHarness
	rm -rf $(SRCDIR)/*.class
	
harn: 
	javac Harness.java dictionary/*.java
	java Harness

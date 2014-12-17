all:
	javac -d bin -cp ./ src/*.java

go:
	java -cp bin ContentAwareFill

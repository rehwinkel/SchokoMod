import os

files = os.listdir(".")

for file in files:
	if "schoko" in file:
		name = file.lower().replace("schokobar", "chocolate_bar_")
		os.rename(file, name)
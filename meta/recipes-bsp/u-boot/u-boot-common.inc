HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
DESCRIPTION = "U-Boot, a boot loader for Embedded boards based on PowerPC, \
ARM, MIPS and several other processors, which can be installed in a boot \
ROM and used to initialize and test the hardware or to download and run \
application code."
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native python3-setuptools-native"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "62e2ad1ceafbfdf2c44d3dc1b6efc81e768a96b9"

SRC_URI = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master \
           file://0001-include-config_distro_bootcmd.h-Check-go-before-boot.patch \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit pkgconfig

do_configure[cleandirs] = "${B}"

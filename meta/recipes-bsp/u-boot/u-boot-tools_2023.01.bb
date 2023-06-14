require u-boot-common.inc
require u-boot-tools.inc

SRC_URI += " \
    file://0001-Revert-config-tools-only-add-VIDEO-to-build-bmp_logo.patch \
    file://0001-mkimage-Use-PATH_MAX-for-path-length.patch \
"
